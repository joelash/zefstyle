(defproject zefstyle "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.9.0" :scope "provided"]
                 [org.clojure/clojurescript "1.10.339" :scope "provided"]
                 [reagent "0.8.1" :exclusions [cljsjs/react cljsjs/react-dom]]]

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
                                       :foreign-libs [{:file "public/js/bundle.js"
                                                       :provides ["cljsjs.react" "react" "cljsjs.react.dom" "webpack.bundle"]}]
                                       :optimizations :none
                                       :pretty-print  true}}
                       :release
                       {:source-paths ["src" "env/prod/cljs"]
                        :compiler
                                      {:output-to "public/js/app.js"
                                       :output-dir "public/js/release"
                                       :asset-path   "js/out"
                                       :optimizations :advanced
                                       :foreign-libs [{:file "public/js/bundle.js"
                                                       :provides ["cljsjs.react" "react" "cljsjs.react.dom" "webpack.bundle"]}]
                                       :pretty-print false}}}}

  :aliases {"release" ["do" "clean" ["cljsbuild" "once" "release"]]}

  :profiles {:dev {:dependencies [[lein-figwheel "0.5.16"]
                                  [org.clojure/tools.nrepl "0.2.12"]
                                  [com.cemerick/piggieback "0.2.2-SNAPSHOT"]]}})
