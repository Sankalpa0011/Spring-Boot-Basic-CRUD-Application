package com.springbootacademy.batch7.pos.service.impl;

import com.springbootacademy.batch7.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch7.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch7.pos.entity.Item;
import com.springbootacademy.batch7.pos.repo.ItemRepo;
import com.springbootacademy.batch7.pos.service.ItemService;
import com.springbootacademy.batch7.pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
        Item item = itemMapper.entityToDTO(itemSaveRequestDTO);
        item.setActiveState(true);

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
            throw new RuntimeException("not found");
        }
    }
}
