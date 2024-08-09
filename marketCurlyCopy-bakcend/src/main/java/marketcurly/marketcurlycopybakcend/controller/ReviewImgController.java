package marketcurly.marketcurlycopybakcend.controller;

import lombok.RequiredArgsConstructor;
import marketcurly.marketcurlycopybakcend.controller.controllerInterface.ReviewImgControllerDocs;
import marketcurly.marketcurlycopybakcend.domain.ReviewImg;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviewImg")
public class ReviewImgController implements ReviewImgControllerDocs {
  @Override
  public ResponseEntity<ReviewImg.ReviewImgResponse> createReviewImg(ReviewImg.ReviewImgRequest request) {
    return null;
  }

  @Override
  public ResponseEntity<ReviewImg.ReviewImgResponse> updateReviewImg(ReviewImg.ReviewImgRequest request) {
    return null;
  }

  @Override
  public ResponseEntity<ReviewImg.ReviewImgResponse> getReviewImg(ReviewImg.ReviewImgRequest request) {
    return null;
  }

  @Override
  public ResponseEntity<ReviewImg.ReviewImgResponse> deleteReviewImg(Long reviewimgId) {
    return null;
  }
}
