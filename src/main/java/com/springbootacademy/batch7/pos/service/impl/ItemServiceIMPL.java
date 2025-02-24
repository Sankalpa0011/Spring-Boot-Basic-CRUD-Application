package com.springbootacademy.batch7.pos.service.impl;

import com.springbootacademy.batch7.pos.dto.paginated.PaginatedResponseItemDTO;
import com.springbootacademy.batch7.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch7.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch7.pos.entity.Item;
import com.springbootacademy.batch7.pos.exception.NotFoundException;
import com.springbootacademy.batch7.pos.repo.ItemRepo;
import com.springbootacademy.batch7.pos.service.ItemService;
import com.springbootacademy.batch7.pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item = new Item(
//                1,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringUnitType(),
//                itemSaveRequestDTO.getBalanceQty(),
//                itemSaveRequestDTO.getSupplierPrice(),
//                itemSaveRequestDTO.getSellingPrice(),
//                true
//        );
//        itemRepo.save(item);
//        return itemSaveRequestDTO.getItemName() + " Saved Successful";
        //Item item = modelMapper.map(itemSaveRequestDTO, Item.class);  meka wenuwata mapstruct yodagena yata eka gahala tiyenne
        Item item = itemMapper.dtoToEntity(itemSaveRequestDTO);
        item.setActiveState(false);

        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return item.getItemId() + " saved successful";
        } else {
            throw new DuplicateKeyException("already added item");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName, b);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS =  modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>() {}.getType());
            return itemGetResponseDTOS;
        } else {
            throw new RuntimeException("not found");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName, b);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS =  itemMapper.entityListToDTOList(items);
            return itemGetResponseDTOS;
        } else {
            throw new RuntimeException("Item Is Not Active");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByActiveStatus(boolean activeStatus) {
        List<Item> items = itemRepo.findAllByActiveStateEquals(activeStatus);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS =  itemMapper.entityListToDTOList(items);
            return itemGetResponseDTOS;
        } else {
            throw new NotFoundException("No Items Found");
        }
    }


    // Pagination
    @Override
    public PaginatedResponseItemDTO getItemsPaginated(int page, int size) {
        Page<Item> items = itemRepo.findAll(PageRequest.of(page, size));
        return new PaginatedResponseItemDTO(
                itemMapper.PageEntityToListDTO(items),
                itemRepo.count()
        );
    }

    @Override
    public PaginatedResponseItemDTO getItemByActiveStatusPaginated(boolean activeStatus, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(activeStatus, PageRequest.of(page, size));
        int count = itemRepo.countAllByActiveStateEquals(activeStatus);
        if (items.getSize() < 1) {
            throw new NotFoundException("No Items Found");
        }
        PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                itemMapper.PageEntityToListDTO(items),
                count
        );
        return paginatedResponseItemDTO;
    }
}
