package marketcurly.marketcurlycopybakcend.controller.controllerInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import marketcurly.marketcurlycopybakcend.domain.Review;
import marketcurly.marketcurlycopybakcend.domain.ReviewImg;
import marketcurly.marketcurlycopybakcend.domain.ShoppingBag;
import marketcurly.marketcurlycopybakcend.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "REVIEWIMG API", description = "reviewimg related apis")
public interface ReviewImgControllerDocs {
  //1.create
  @Operation(summary="POST: create reviewimg", description = "create reviewimg with its values")
  @Parameters(value ={
          @Parameter(name ="review", description = "review"),
          @Parameter(name ="imgUrl", description = "imgUrl"),
  })
  @ApiResponse(responseCode = "200", description = "reviewimg created successfully", content = @Content(
          schema = @Schema(implementation = ReviewImg.ReviewImgResponse.class )
  ))
  @PostMapping("/create")
  public ResponseEntity<ReviewImg.ReviewImgResponse> createReviewImg (@RequestBody ReviewImg.ReviewImgRequest request);

  //2.update
  @Operation(summary="PUT: update reviewimg", description = "update reviewimg with its values")
  @Parameters(value ={
          @Parameter(name ="review", description = "review"),
          @Parameter(name ="imgUrl", description = "imgUrl"),
  })
  @ApiResponse(responseCode = "200", description = "reviewimg updated successfully", content = @Content(
          schema = @Schema(implementation = ReviewImg.ReviewImgResponse.class  )
  ))
  @PutMapping("/update")
  public ResponseEntity<ReviewImg.ReviewImgResponse> updateReviewImg (@RequestBody ReviewImg.ReviewImgRequest request);

  //3.read
  @Operation(summary="GET: get reviewimg info", description = "get reviewimg info with its values")
  @Parameters(value ={
          @Parameter(name ="review", description = "review"),
          @Parameter(name ="imgUrl", description = "imgUrl"),
  })
  @ApiResponse(responseCode = "200", description = "got reviewimg info successfully", content = @Content(
          schema = @Schema(implementation = ReviewImg.ReviewImgResponse.class  )
  ))
  @GetMapping("/getinfo")
  public ResponseEntity<ReviewImg.ReviewImgResponse> getReviewImg (@RequestBody ReviewImg.ReviewImgRequest request);

  //4.delete
  @Operation(summary = "DELETE: delete reviewimg", description = "delete reviewimg with its values")
  @Parameters(value = {
          @Parameter(name = "reviewimgId", description = "reviewimgId", required = true),
  })
  @ApiResponse(responseCode = "200", description = "user deleted successfully", content = @Content(
          schema =  @Schema(implementation = ReviewImg.ReviewImgResponse.class  )

  ))
  @DeleteMapping("/delete")
  public ResponseEntity<ReviewImg.ReviewImgResponse> deleteReviewImg (@RequestParam Long reviewimgId);
}
