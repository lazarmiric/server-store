(ns domain.product_detail
    (:require [schema.core :as sch]
              [ring.swagger.schema :refer [coerce!]]))
  
  (sch/defschema ProductDetail {
    :ProductDetailID       Integer
    :Brand                 String
    :CountryOfOrigin       String
    :YearOfGarancy         Integer
  })
  
  (sch/defschema NewProductDetail (dissoc ProductDetail :ProductDetailID))