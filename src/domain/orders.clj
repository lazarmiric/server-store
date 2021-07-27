(ns domain.orders
    (:require [schema.core :as sch]
              [ring.swagger.schema :refer [coerce!]]))
  
  (sch/defschema Orders {
    :OrderID                    Integer
    :TotalPayment               Double
    :CustomerID                 Integer
    :ProductID                  Integer
    :TotalOrderOfSameProduct    Integer
  })
  
  (sch/defschema NewOrder (dissoc Orders :OrderID))