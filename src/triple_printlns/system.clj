(ns triple-printlns.system
  (:require [com.stuartsierra.component :as component]
            [triple-printlns.handler :as core]))

(defn create-system []
  (component/system-map :app (core/map->Routes {})))
