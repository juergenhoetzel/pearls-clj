(ns pearls-clj.tests.smallest-free-number-dc
  (:use pearls-clj.smallest-free-number-dc)
  (:use clojure.test))

(deftest find-smallest-free-number []
         (let [sample-coll [8 23 9 0 12 11 1 10 13 7 41 4 14 21 5 17 3 19 2 6]]
           (is (= 15 (smallest-free-number sample-coll)))))