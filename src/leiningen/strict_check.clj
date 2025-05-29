(ns leiningen.strict-check
  "Check syntax and warn on reflection."
  (:require [clojure.java.shell :as sh]
            [clojure.string :as str]))


(defn- get-lein-executable []
  (if (str/includes? (System/getProperty "os.name") "Windows ")
    "lein.bat"
    "lein.sh"))

(defn strict-check
  "Check syntax and warn on reflection and exit with non 0 status code when errors were detected."
  ([_]
   (let [result (sh/sh (get-lein-executable) "check")]
     (when (.contains ^String (:err result) "Reflection warning, ")
       (do
         (println (:err result))
         (System/exit 1))))))