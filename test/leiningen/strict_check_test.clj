(ns leiningen.strict-check-test
  (:require [leiningen.strict-check :as sc]
            [mock-clj.core :as mc]
            [clojure.java.shell :as sh]
            [clojure.test :refer [deftest is]]))

(deftest test-strict-check
  (mc/with-mock [sc/exit nil
                 sh/sh {:err "Reflection warning, jj/core/protocols.clj:55:5 - call to method write can't be resolved (target class\n is unknown).\nReflection warning, jj/core/protocols.clj:56:5 - reference to field close can't be resolved.\n"}]
                (sc/strict-check {})
                (is (= (mc/calls sc/exit) [nil]))
                (is (= 1 (mc/call-count sc/exit)))
                (is (mc/called? sc/exit))))


(deftest test-strict-check-filter
  (mc/with-mock [sc/exit nil
                 sh/sh {:err "Reflection warning, jj/core/protocols.clj:55:5 - call to method write can't be resolved (target class\n is unknown).\nReflection warning, jj/core/protocols.clj:57:5 - reference to field close can't be resolved.\n"}]
                (sc/strict-check {:strict-check {:filter ["jj.core"]}})
                (is (= (mc/calls sc/exit) []))
                (is (= 0 (mc/call-count sc/exit)))))