package com.springbootacademy.batch7.pos.dto.paginated;

import com.springbootacademy.batch7.pos.dto.response.OrderDetailsResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetailsDTO {
    private List<OrderDetailsResponseDTO> list;
    private long dataCount;
}
