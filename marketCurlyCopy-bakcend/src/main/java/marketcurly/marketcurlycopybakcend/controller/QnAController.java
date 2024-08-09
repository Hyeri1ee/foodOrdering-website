package marketcurly.marketcurlycopybakcend.controller;

import lombok.RequiredArgsConstructor;
import marketcurly.marketcurlycopybakcend.controller.controllerInterface.QnAControllerDocs;
import marketcurly.marketcurlycopybakcend.domain.QnA;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qna")
public class QnAController implements QnAControllerDocs {
  @Override
  public ResponseEntity<QnA.QnAResponse> createQnA(QnA.QnARequest request) {
    return null;
  }

  @Override
  public ResponseEntity<QnA.QnAResponse> updateQnA(QnA.QnARequest request) {
    return null;
  }

  @Override
  public ResponseEntity<QnA.QnAResponse> getInfoQnA(Long QnAId) {
    return null;
  }

  @Override
  public ResponseEntity<QnA.QnAResponse> deleteQnA(Long QnAId) {
    return null;
  }
}
