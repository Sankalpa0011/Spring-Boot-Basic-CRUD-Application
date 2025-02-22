package com.springbootacademy.batch7.pos.util.mappers;

import com.springbootacademy.batch7.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch7.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch7.pos.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDTOList(List<Item> items);
    Item entityToDTO(ItemSaveRequestDTO itemSaveRequestDTO);
}
