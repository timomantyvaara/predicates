(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (every? whitespace? string) (empty? string)))

(defn has-award? [book award]
  (boolean (award (:awards book))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (:awards book)]
    (every? book-awards awards)))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (let [foo (map pred a-seq)]
    (or (empty? foo) (every? boolean foo))))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))


(defn foo [n]
  (let [pred (fn [x] (mod n x))]
  (every? pos? (map pred (range 2 n)))))
;^^
