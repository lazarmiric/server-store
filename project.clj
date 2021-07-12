(defproject server "0.1.0-SNAPSHOT"
  :description "CRUD Application - Store"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
  [metosin/compojure-api "2.0.0-alpha30"]
  [korma "0.4.3"]
  [mysql/mysql-connector-java "8.0.12"]
  [ring/ring "1.6.3"]
 ]
 :ring {:handler handler.handler/app}
 :profiles {:dev {
                   :dependencies [[ring/ring-mock "0.4.0"]]
                   :plugins [[lein-ring "0.12.5"]]}}
 :repl-options {:init-ns backend.core})
