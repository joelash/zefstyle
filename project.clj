(defproject zefstyle "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 [reagent "0.8.1"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.16"]]

  :min-lein-version "2.5.0"

  :clean-targets ^{:protect false}
[:target-path
 [:cljsbuild :builds :app :compiler :output-dir]
 [:cljsbuild :builds :app :compiler :output-to]]

  :resource-paths ["public"]

  :figwheel {:http-server-root "public"
             :nrepl-port 7002
             :server-port 3450
             :nrepl-middleware ["cemerick.piggieback/wrap-cljs-repl"]
             :css-dirs ["public/css"]}

  :cljsbuild {:builds {:app
                       {:source-paths ["src" "env/dev/cljs"]
                        :compiler
                                      {:main "zefstyle.dev"
                                       :output-to "public/js/app.js"
                                       :output-dir "public/js/out"
                                       :asset-path   "js/out"
                                       :source-map true
                                       :npm-deps {:react "16.3.2"
                                                  :react-dom "16.3.2"
                                                  :resolve "1.3.3"
                                                  :react-player "0.18.0"}
                                       :install-deps true
                                       :optimizations :none
                                       :pretty-print  true}}
                       :release
                       {:source-paths ["src" "env/prod/cljs"]
                        :compiler
                                      {:output-to "public/js/app.js"
                                       :output-dir "public/js/release"
                                       :asset-path   "js/out"
                                       :optimizations :advanced
                                       :pretty-print false}}}}

  :aliases {"release" ["do" "clean" ["cljsbuild" "once" "release"]]}

  :profiles {:dev {:dependencies [[lein-figwheel "0.5.16"]
                                  [org.clojure/tools.nrepl "0.2.12"]
                                  [com.cemerick/piggieback "0.2.2-SNAPSHOT"]]}})
