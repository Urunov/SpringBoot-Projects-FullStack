package com.urunov.jwtauth.store;

public class Offset implements JsonSerializable {

        private int offset;
        private int limit;
        private long totalCount;
        private boolean totalCountRequested;
        private String sortingField;
        private Offset.SortDirection sortDirection;

        public Offset(int offset, int limit) {
            this.offset = offset;
            this.limit = limit > 0 ? limit : 10;
            this.sortDirection = Offset.SortDirection.ASCENDING;
            this.totalCountRequested = false;
        }

        public Offset(int offset, int limit, Offset.SortDirection sortDirection, String sortingField) {
            this.offset = offset;
            this.limit = limit > 0 ? limit : 10;
            this.sortDirection = sortDirection;
            this.sortingField = sortingField;
            this.totalCountRequested = false;
        }

        public static Offset newDefault() {
            return new Offset(0, 10);
        }

        public static Offset newOne(int offset, int limit) {
            return new Offset(offset, limit);
        }

        public static Offset newOne(int offset, int limit, Offset.SortDirection sortDirection, String sortingField) {
            return new Offset(offset, limit, sortDirection, sortingField);
        }

        public boolean ascendingSort() {
            return Offset.SortDirection.ASCENDING == this.sortDirection;
        }

        public String toString() {
            return this.toJson();
        }

        public static Offset fromJson(String json) {
            return (Offset)JsonUtil.fromJson(json, Offset.class);
        }

        public static Offset sample() {
            return new Offset(0, 20);
        }

        public int offset() {
            return this.offset;
        }

        public int limit() {
            return this.limit;
        }

        public int page() {
            return this.offset / this.limit;
        }

        public int sum() {
            return this.offset + this.limit;
        }

        public static void main(String[] args) {
            System.out.println(sample().toPrettyJson());
            System.out.println(sample().ascendingSort());
        }

        public int getOffset() {
            return this.offset;
        }

        public int getLimit() {
            return this.limit;
        }

        public long getTotalCount() {
            return this.totalCount;
        }

        public boolean isTotalCountRequested() {
            return this.totalCountRequested;
        }

        public String getSortingField() {
            return this.sortingField;
        }

        public Offset.SortDirection getSortDirection() {
            return this.sortDirection;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public void setTotalCount(long totalCount) {
            this.totalCount = totalCount;
        }

        public void setTotalCountRequested(boolean totalCountRequested) {
            this.totalCountRequested = totalCountRequested;
        }

        public void setSortingField(String sortingField) {
            this.sortingField = sortingField;
        }

        public void setSortDirection(Offset.SortDirection sortDirection) {
            this.sortDirection = sortDirection;
        }

        public Offset() {
        }


    public static enum SortDirection {
            ASCENDING,
            DESCENDING;

            private SortDirection() {
            }
        }
}
