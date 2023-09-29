(ns untitled2.core)

(defn filter-and-print-elements-more-than-n-times [lst n]
  (let [element-counts (frequencies lst)]
    (doseq [[element count] element-counts
            :when (> count n)]
      (print element " "))))

(defn main []
  (println "Введите элементы списка (через пробел), затем n:")
  (let [input (read-line)
        parsed-input (clojure.string/split input #"\s+")
        n (-> (read-line) Integer.)]
    (filter-and-print-elements-more-than-n-times parsed-input n)))

(main)

