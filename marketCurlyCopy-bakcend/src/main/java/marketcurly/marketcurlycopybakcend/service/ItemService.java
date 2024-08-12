package marketcurly.marketcurlycopybakcend.service;

import marketcurly.marketcurlycopybakcend.domain.Item;
import marketcurly.marketcurlycopybakcend.domain.User;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.ItemRepositoryInterface;

import java.util.Optional;

public class ItemService {
  private final ItemRepositoryInterface itemRepository;

  public ItemService(ItemRepositoryInterface itemRepository) {
    this.itemRepository = itemRepository;
  }

  public void save(Item.ItemRequest request) {
    validateDuplicate(request);
    itemRepository.save(request.toEntity());
  }

  private void validateDuplicate(Item.ItemRequest request) {
    getItem(request.getItemName())
            .ifPresent(m ->{
              throw new IllegalStateException("이미 존재하는 아이템입니다.");
            });
  }

  public Optional<Item.ItemResponse> getItem(String name) {
    return Optional.ofNullable(itemRepository.findByName(name))
            .map(Item.ItemResponse::new);
  }

  public void deleteItem(String name) {
    Optional<Item.ItemResponse> found = Optional.ofNullable(itemRepository.findByName(name))
            .map(Item.ItemResponse::new);
    if (found != null)
      itemRepository.delete(found);
    else
      throw new IllegalStateException("아이템이 존재하지 않습니다.");
  }

  public Item updateBasedOnRequest(Optional<Item.ItemResponse> itemResponse, Item.ItemRequest request) {
    Item item = itemRepository.findByName(itemResponse.get().getItemName());

    item.update(request);
    return itemRepository.save(item);
  }
}
