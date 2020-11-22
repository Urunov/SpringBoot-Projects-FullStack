package com.urunov.payload.good;

import lombok.*;

import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GoodListResponse
{

    List<GoodResponse> goodList;

}
