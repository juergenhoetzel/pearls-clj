(ns perls-clj.smallest-free-number
  (:use clojure.set))

(defn- without [coll s]
  (filter (complement s) coll))

(defn accum-array [accum-fn v upper-bound assoc-coll]
  (reduce
   (fn [v [k val]]
     (update-in v [k] accum-fn  val))
   (apply vector (repeat (inc upper-bound) v))
   assoc-coll))

(defn checklist [coll]
  (let [n (count coll)]
    (accum-array #(or %1 %2) false n
                 (partition 2
                  (interleave
                   (filter #(<= % n) coll)
                   (repeat true))))))

(defn smallest-free-number [coll]
  (->> (checklist coll)
       (take-while identity)
       (count)))

(defn smallest-free-number-naive [coll]
  (first (without (iterate inc 0) (set coll))))
