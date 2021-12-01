(ns scicloj.viz.config)

(def ^:dynamic *use-tempfiles?* nil)

(defn notespace-loaded? []
  (-> 'scicloj.notespace.v4.api/restart!
      resolve
      some?))

(defn use-tempfiles? []
  (if (nil? *use-tempfiles?*)
    (notespace-loaded?)
    *use-tempfiles?*))
