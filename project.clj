(defproject org.clojars.jj/strict-check "1.0.3-SNAPSHOT"
  :description "A wrapper plugin on top of lein check. It checks for reflection warnings in a project,
  and exits with non 0 status, if a reflection warnings were detected."
  :url "https://github.com/ruroru/lein-strict-check"
  :license {:name "EPL-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.12.2"]
                 [leiningen-core "2.12.0"]]

  :profiles {:test {:dependencies [[mock-clj "0.2.1"]]}}
  :deploy-repositories [["clojars" {:url      "https://repo.clojars.org"
                                    :username :env/clojars_user
                                    :password :env/clojars_pass}]]
  :plugins [[org.clojars.jj/bump "1.0.4"]
            [org.clojars.jj/bump-md "1.1.0"]
            [org.clojars.jj/strict-check "1.0.2"]])
