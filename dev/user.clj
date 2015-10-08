(ns ^{:skip-aot true}
  user
  (:require [triple-printlns.system :as app]
            [reloaded.repl :refer [reset go stop]]))

(reloaded.repl/set-init! #(app/create-system))
