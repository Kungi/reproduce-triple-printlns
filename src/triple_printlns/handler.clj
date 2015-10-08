(ns triple-printlns.handler
  (:require [compojure.core :as compojure :refer [GET]]
            [com.stuartsierra.component :as component]
            [ring.adapter.jetty :as jetty]
            [taoensso.timbre :as log]))

(compojure/defroutes app
  (GET "/foo" [] (println "Fooo!!!")))

(defrecord Routes []
     component/Lifecycle

     (start [this]
       (log/trace ";; Starting " name)
       (let [server (jetty/run-jetty app {:port 3333 :join? false})]
         (assoc this :server server)))

     (stop [this]
       (log/trace ";; Stopping " name)
       (.stop (:server this))
       (dissoc this :server)))
