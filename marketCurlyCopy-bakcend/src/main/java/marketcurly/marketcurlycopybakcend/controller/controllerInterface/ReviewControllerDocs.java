package marketcurly.marketcurlycopybakcend.controller.controllerInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import marketcurly.marketcurlycopybakcend.domain.Review;
import marketcurly.marketcurlycopybakcend.domain.ShoppingBag;
import marketcurly.marketcurlycopybakcend.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "REVIEW API", description = "review related apis")
public interface ReviewControllerDocs {

  //1.create
  @Operation(summary="POST: create review", description = "create review with its values")
  @Parameters(value ={
          @Parameter(name ="title", description = "title"),
          @Parameter(name ="content", description = "content"),
          @Parameter(name ="loginId", description = "login id"),
          @Parameter(name ="reviewImgList", description = "img list of a review")

  })
  @ApiResponse(responseCode = "200", description = "review created successfully", content = @Content(
          schema = @Schema(implementation = Review.ReviewResponse.class )
  ))
  @PostMapping("/create")
  public ResponseEntity<Review.ReviewResponse> createReview (@RequestBody Review.ReviewRequest request);

  //2.update
  @Operation(summary="PUT: update review", description = "update review with its values")
  @Parameters(value ={
          @Parameter(name ="title", description = "title"),
          @Parameter(name ="content", description = "content"),
          @Parameter(name ="loginId", description = "login id"),
          @Parameter(name ="reviewImgList", description = "img list of a review")

  })
  @ApiResponse(responseCode = "200", description = "review updated successfully", content = @Content(
          schema = @Schema(implementation = Review.ReviewResponse.class )
  ))
  @PutMapping("/update")
  public ResponseEntity<Review.ReviewResponse> updateReview (@RequestBody Review.ReviewRequest request);

  //3.read
  @Operation(summary="GET: get review info", description = "get review info with its values")
  @Parameters(value ={
          @Parameter(name ="title", description = "title"),
          @Parameter(name ="content", description = "content"),
          @Parameter(name ="loginId", description = "login id"),
          @Parameter(name ="reviewImgList", description = "img list of a review")

  })
  @ApiResponse(responseCode = "200", description = "got review info successfully", content = @Content(
          schema = @Schema(implementation = Review.ReviewResponse.class )
  ))
  @GetMapping("/getinfo")
  public ResponseEntity<Review.ReviewResponse> getReview (@RequestBody Review.ReviewRequest request);

  //4.delete
  @Operation(summary = "DELETE: delete review", description = "delete review with its values")
  @Parameters(value = {
          @Parameter(name = "revewId", description = "reviewId", required = true),
  })
  @ApiResponse(responseCode = "200", description = "user deleted successfully", content = @Content(
          schema = @Schema(implementation = Review.ReviewResponse.class)

  ))
  @DeleteMapping("/delete")
  public ResponseEntity<Review.ReviewResponse> deleteReview (@RequestParam Long reviewId);
}
