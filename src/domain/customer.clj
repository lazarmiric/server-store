(ns domain.customer
    (:require [schema.core :as sch]
              [ring.swagger.schema :refer [coerce!]]))
  
  (sch/defschema Customer {
    :CustomerID   Integer
    :Name         String
    :LastName     String
    :City         String
  })
  
  (sch/defschema NewCustomer (dissoc Customer :CustomerID))