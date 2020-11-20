package com.urunov.payload;

import lombok.*;

import java.util.List;


/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Data
@NoArgsConstructor
@Getter
@Setter
public class PagedResponse<T> {

    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;

 public PagedResponse(List<T> content, int page, int size, long totalElements, int totalPages, boolean last) {
  this.content = content;
  this.page = page;
  this.size = size;
  this.totalElements = totalElements;
  this.totalPages = totalPages;
  this.last = last;
 }



}
