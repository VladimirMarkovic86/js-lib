(defproject org.vladimir/js-lib "0.1.0"
  :description    "JavaScript library"
  :url            "http://gitlab:1610/VladimirMarkovic86/js-lib"
  :license        {:name "Eclipse Public License"
                   :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies   [[org.clojure/clojure    "1.9.0"]
                    ; https://clojure.org/api/api
                   [org.clojure/clojurescript "1.9.946"]
                    ; https://clojurescript.org/guides/quick-start#clojurescript-compiler
                    ; https://clojurescript.org/reference/dependencies
                   [org.vladimir/ajax-lib "0.1.0"]
                   [org.vladimir/htmlcss-lib "0.1.0"]
                   ]
  :source-paths ["src/cljs"])

