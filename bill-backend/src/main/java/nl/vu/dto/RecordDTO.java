package nl.vu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordDTO {
    private Integer userId;
    private String activity;
    private float totalAmount;
    private String time;
}
