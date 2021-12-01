(ns scicloj.viz.paths
  (:require [clojure.string :as string]
            [clojure.java.io :as io]))

(defn url? [path]
  (->> path
       (re-matches #"^http.*")))

(defn file-type [path]
  (-> path
      (string/split #"\.")
      last))

(defn exists? [path]
  (-> path
      io/file
      (.exists)))

(defn throw-if-not-exists! [path]
  (if (exists? path)
    path
    (throw (ex-info "File does not exist"
                    {:path path}))))

