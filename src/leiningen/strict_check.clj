(ns leiningen.strict-check
  "Check syntax and warn on reflection."
  (:require [clojure.java.shell :as sh]
            [clojure.string :as str]))

(defn exit []
  (System/exit 1))

(defn- get-lein-executable []
  (if (str/includes? (System/getProperty "os.name") "Windows ")
    "lein.bat"
    "lein"))

(defn strict-check
  "Check syntax and warn on reflection and exit with non 0 status code when errors were detected."
  ([project]
   (let [filter-list (get-in project [:strict-check :filter] [])
         result (sh/sh (get-lein-executable) "check")]
     (when (.contains ^String (:err result) "Reflection warning, ")
       (let [warning-lines (->> (str/split (:err result) #"\n")
                                (filter #(str/includes? ^String % "Reflection warning, ")))
             unfiltered-warnings (if (seq filter-list)
                                   (remove (fn [line]
                                             (some (fn [filter-pattern]
                                                     (let [namespace-from-path (str/replace line "/" ".")]
                                                       (str/includes? namespace-from-path filter-pattern)))
                                                   filter-list))
                                           warning-lines)
                                   warning-lines)]
         (when (seq unfiltered-warnings)
           (println (:err result))
           (exit)))))))

