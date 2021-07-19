(ns domain.order
    (:require [schema.core :as sch]
              [ring.swagger.schema :refer [coerce!]]))
  
  (sch/defschema Order {
    :OrderID                    Integer
    :TotalPayment               Double
    :CustomerID                 Integer
    :ProductID                  Integer
    :TotalOrderOfSameProduct    Integer
  })
  
  (sch/defschema NewOrder (dissoc Order :OrderID))