package marketcurly.marketcurlycopybakcend.controller.controllerInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import marketcurly.marketcurlycopybakcend.domain.QnA;
import marketcurly.marketcurlycopybakcend.domain.ReviewImg;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "QNA API", description = "QNA related apis")
public interface QnAControllerDocs {
  //1.create
  @Operation(summary="POST: create QNA", description = "create QNA with its values")
  @Parameters(value ={
          @Parameter(name ="title", description = "title"),
          @Parameter(name ="content", description = "content"),
  })
  @ApiResponse(responseCode = "200", description = "QNA created successfully", content = @Content(
          schema = @Schema(implementation = QnA.QnAResponse.class )
  ))
  @PostMapping("/create")
  public ResponseEntity<QnA.QnAResponse> createQnA (@RequestBody QnA.QnARequest request);

  //2.update
  @Operation(summary="PUT: update QNA", description = "update QNA with its values")
  @Parameters(value ={
          @Parameter(name ="title", description = "title"),
          @Parameter(name ="content", description = "content"),
  })
  @ApiResponse(responseCode = "200", description = "reviewimg updated successfully", content = @Content(
          schema = @Schema(implementation = QnA.QnAResponse.class )
  ))
  @PutMapping("/update")
  public ResponseEntity<QnA.QnAResponse> updateQnA (@RequestBody QnA.QnARequest request);

  //3.read
  @Operation(summary="GET: get QNA info", description = "get QNA info with its values")
  @Parameters(value ={
          @Parameter(name ="QnAId", description = "QnAId"),
  })
  @ApiResponse(responseCode = "200", description = "got QnA info successfully", content = @Content(
          schema = @Schema(implementation = QnA.QnAResponse.class )
  ))
  @GetMapping("/getinfo")
  public ResponseEntity<QnA.QnAResponse> getInfoQnA (@RequestParam Long QnAId);

  //4.delete
  @Operation(summary = "DELETE: delete QNA", description = "delete QNA with its values")
  @Parameters(value = {
          @Parameter(name ="QnAId", description = "QnAId"),  }
  )
  @ApiResponse(responseCode = "200", description = "user deleted successfully", content = @Content(
          schema = @Schema(implementation = QnA.QnAResponse.class )

  ))
  @DeleteMapping("/delete")
  public ResponseEntity<QnA.QnAResponse> deleteQnA (@RequestParam Long QnAId);
}
