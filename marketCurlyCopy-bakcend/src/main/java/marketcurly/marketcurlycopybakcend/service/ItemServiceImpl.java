package marketcurly.marketcurlycopybakcend.service;

import lombok.RequiredArgsConstructor;
import marketcurly.marketcurlycopybakcend.domain.Item;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.ItemRepository;
import marketcurly.marketcurlycopybakcend.repository.repositoryInterface.ShoppingBagRepository;
import marketcurly.marketcurlycopybakcend.service.serviceInterface.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceImpl implements ItemService {
  private final ItemRepository itemRepository;

  @Override
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

  @Override
  public Optional<Item.ItemResponse> getItem(String name) {
    return Optional.ofNullable(itemRepository.findByName(name))
            .map(Item.ItemResponse::new);
  }

  @Override
  public void deleteItem(String name) {
    Optional<Item.ItemResponse> found = Optional.ofNullable(itemRepository.findByName(name))
            .map(Item.ItemResponse::new);
    if (found != null)
      itemRepository.delete(found);
    else
      throw new IllegalStateException("아이템이 존재하지 않습니다.");
  }
}
