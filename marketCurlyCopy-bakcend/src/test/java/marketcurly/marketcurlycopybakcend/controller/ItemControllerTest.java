package marketcurly.marketcurlycopybakcend.controller;

import marketcurly.marketcurlycopybakcend.domain.Item;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.ItemRepository;
import org.apache.coyote.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemControllerTest {
  private ItemController itemController;
  private ItemRepository itemRepository;
  private Item.ItemRequest itemRequest;

  @BeforeEach
  public void makeItemRequest(){
    itemRequest = new Item.ItemRequest("아보카도연어세트","냉장식품",
            "몸에 좋은 아보카도 + 싱싱한 연어" , "아보카도를 저렴한 가격에\n연어를 싱싱하게 맛보세요!\n이제 아침밥은 아보카도연어세트로!!",
            true, 13000, 15);

  }

  @Test
  void GivenNewItemInfo_WhenCreatingNewItem_ThenTheNewItemIsCreated() {
    itemController.createItem(itemRequest);
    ResponseEntity savedItemResponse = itemController.getinfoItem("아보카도연어세트");
    //상태코드 확인 : httpstatus = 200
    assertThat(savedItemResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    Item found = itemRepository.findByName("아보카도연어세트");
    //저장된 값 확인
    assertThat(found.getName()).isEqualTo("아보카도연어세트");
  }

  @Test
  void GivenExistingItemInfo_WhenCreatingNewItem_ThenTheNewItemIsNotCreated(){

  }

  @Test
  void updateItem() {
  }

  @Test
  void getinfoItem() {
  }

  @Test
  void deleteItem() {
  }
}