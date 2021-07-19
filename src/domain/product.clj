(ns domain.product
    (:require [schema.core :as sch]
              [ring.swagger.schema :refer [coerce!]]))
  
  (sch/defschema Product {
    :ProductID               Integer
    :ProductName             String
    :ProductType             String
    :ProductDetailID         Integer
    :Price                   Double
  })
  
  (sch/defschema NewProduct (dissoc Product :ProductID))