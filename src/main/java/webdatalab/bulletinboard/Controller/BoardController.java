package webdatalab.bulletinboard.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webdatalab.bulletinboard.domain.Board;
import webdatalab.bulletinboard.service.BoardService;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/hello")
    public String Hello() {
        return "boards/hello"; // 뷰 파일의 경로와 파일 이름만 반환합니다.
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("cnt", service.boardCount());
        model.addAttribute("test", service.boardList());

        return "boards/hello"; // 뷰 파일의 경로와 파일 이름만 반환합니다.
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("list", service.boardList());

        return "boards/main"; // 뷰 파일의 경로와 파일 이름만 반환합니다.
    }

    @GetMapping("/view/{boardId}") // URL 경로에 게시글 ID를 포함합니다.
    public String viewBoard(Model model, @PathVariable("boardId") Long boardId){ // PathVariable 어노테이션을 사용하여 경로에서 boardId를 받아옵니다.
        model.addAttribute("halo", service.getBoard(boardId));
        return "boards/view"; // 뷰 파일의 경로와 파일 이름만 반환합니다.
    }

    @GetMapping("/upload")
    public String uploadBoardForm(){
        return "/boards/upload";
    }

    @PostMapping("/upload")
    public String uploadBoard(Board board){
        service.uploadBoard(board);
        return "redirect:/board/main";
    }
}
