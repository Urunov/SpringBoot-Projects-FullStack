//package com.urunov.util.resulttransformers;
//
//import com.urunov.dto.FilterAttributesDTO;
//import com.urunov.dto.FilterAttributesWithTotalltemsDTO;
//import com.urunov.dto.SearchSuggestionForThreeAttrDTO;
//import com.urunov.dto.SearchSuggestionForTwoAttrDTO;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * User: hamdamboy
// * Project: security
// * Github: @urunov
// */
//
//
//public class ListResultTransformer {
//
//    public List<FilterAttributesWithTotalltemsDTO>
//    getFilterAttributesWithTotalItemsResultTransformer(String queryStr, HashMap<Integer, Object> mapParams,
//                                                       EntityManager entityManager) {
//
//        Query query = entityManager.createQuery(queryStr);
//
//        if(mapParams != null) {
//            mapParams.forEach(query::setParameter);
//        }
//        return query.unwrap(org.hibernate.query.Query.class)
//                .setResultTransformer((IListResultTransformer)
//                        (tuple, aliases) -> new FilterAttributesWithTotalItemsDTO((Integer) tuple[0],
//                                (String) tuple[1], (Long) tuple[2]
//                        )
//                ).getResultList();
//    }
//
//    public List<FilterAttributesDTO>
//    getFilterAttributesResultTransformer(String queryStr, HashMap<Integer, Object> mapParams,
//                                         EntityManager entityManager) {
//
//        Query query = entityManager.createQuery(queryStr);
//
//        if(mapParams != null) {
//            mapParams.forEach(query::setParameter);
//        }
//
//        return query.unwrap(org.hibernate.query.Query.class)
//                .setResultTransformer((IListResultTransformer)
//                        (tuple, aliases) -> new FilterAttributesDTO((Integer) tuple[0], (String) tuple[1]
//                        )
//                ).setMaxResults(10)
//                .getResultList();
//    }
//
//    public List<SearchSuggestionForThreeAttrDTO>
//    getSearchSuggestionForThreeAttrResultTransformer(String queryStr,
//                                                     EntityManager entityManager) {
//
//        Query query = entityManager.createQuery(queryStr);
//        return query.unwrap(org.hibernate.query.Query.class)
//                .setResultTransformer((IListResultTransformer)
//                        (tuple, aliases) -> new SearchSuggestionForThreeAttrDTO((Integer) tuple[0], (String) tuple[1],
//                                (Integer) tuple[2], (String) tuple[3],(Integer) tuple[4], (String) tuple[5])
//                ).getResultList();
//    }
//
//    public List<SearchSuggestionForTwoAttrDTO>
//    getSearchSuggestionForTwoAttrResultTransformer(String queryStr,
//                                                   EntityManager entityManager) {
//
//        Query query = entityManager.createQuery(queryStr);
//        return query.unwrap(org.hibernate.query.Query.class)
//                .setResultTransformer((IListResultTransformer)
//                        (tuple, aliases) -> new SearchSuggestionForTwoAttrDTO((Integer) tuple[0], (String) tuple[1],
//                                (Integer) tuple[2], (String) tuple[3])
//                ).getResultList();
//    }
//
//}
