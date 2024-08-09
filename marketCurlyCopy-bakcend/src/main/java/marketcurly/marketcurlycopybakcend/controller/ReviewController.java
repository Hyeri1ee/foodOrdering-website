package marketcurly.marketcurlycopybakcend.controller;

import lombok.RequiredArgsConstructor;
import marketcurly.marketcurlycopybakcend.controller.controllerInterface.ReviewControllerDocs;
import marketcurly.marketcurlycopybakcend.domain.Review;
import marketcurly.marketcurlycopybakcend.domain.ShoppingBag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController implements ReviewControllerDocs {

  @Override
  public ResponseEntity<Review.ReviewResponse> createReview(Review.ReviewRequest request) {
    return null;
  }

  @Override
  public ResponseEntity<Review.ReviewResponse> updateReview(Review.ReviewRequest request) {
    return null;
  }

  @Override
  public ResponseEntity<Review.ReviewResponse> getReview(Review.ReviewRequest request) {
    return null;
  }

  @Override
  public ResponseEntity<Review.ReviewResponse> deleteReview(Long reviewId) {
    return null;
  }
}
