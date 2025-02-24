package com.springbootacademy.batch7.pos.util.mappers;

import com.springbootacademy.batch7.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch7.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch7.pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    // entity list to DTO list
    List<ItemGetResponseDTO> entityListToDTOList(List<Item> items);

    // DTO to entity
    Item dtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);

    // Page<Item> items -------> List<ItemGetResponseDTO> list
    // page entity to DTO list
    List<ItemGetResponseDTO> PageEntityToListDTO(Page<Item> items);
}
