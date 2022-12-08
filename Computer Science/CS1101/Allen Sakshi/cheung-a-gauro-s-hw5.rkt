;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname cheung-a-gauro-s-hw5) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #t)))
;;Allen Cheung & Sakshi Gauro
;;acheung & sgauro


;;Question 1
(define-struct river (name ph do tributaries))

;; a River is a (make-river String Number Number ListOfRiver)
;;interp: represents a river where
;;  --name is the name of the river
;;  --ph is the pH of the river (between 0 and 14)
;;  --do is the dissolved oxygen of the river (measured in mg/L)
;;  --tributaries is the tributaries that feed into the river

;; a ListOfRiver is one of
;;    empty
;;    (cons River ListOfRiver)
;;interp: ListOfRiver is a ListOfRiver


;; Question 2
(define BEAVERHEAD (make-river "Beaverhead" 4 6.4 empty))
(define BIG-HOLE (make-river "Big Hole" 4 6.7 empty))
(define JEFFERSON (make-river "Jefferson" 3 7.5 (list BEAVERHEAD BIG-HOLE)))
(define GARDNER (make-river "Gardner" 6 7.4 empty))
(define SHIELDS (make-river "Shields" 6 3.7 empty))
(define BOULDER (make-river "Boulder" 7 7 empty))
(define YELLOWSTONE (make-river "Yellowstone" 5 8.5 (list GARDNER SHIELDS BOULDER)))
(define SUN (make-river "Sun" 7 8.2 empty))
(define MADISON (make-river "Madison" 7 6.7 empty))
(define GALLATIN (make-river "Gallatin" 4 7 empty))
(define MISSOURI (make-river "Missouri" 7 6.5 (list JEFFERSON SUN YELLOWSTONE MADISON GALLATIN)))

;;Question 3
; ;; river-fcn:  River ->
; ;;
; (define (river-fcn a-river)
;     (...  (river-name a-river)
;           (river-ph a-river)
;           (river-do a-river)
;           (list-of-river-fcn (river-tributaries a-river))))
;   
;   
; ;; list-of-river-fcn:  ListOfRiver ->
; ;;
; (define (list-of-river-fcn: alor)
;     (cond [(empty? alor) (...)]
;           [(cons? alor)  (...  (river-fcn (first alor))
;                                (list-of-river-fcn (rest alor)))]))

;;Question 4
;;SIGNATURE/PURPOSE
;;list-acidic-rivers: River -> ListOfString
;;consumes a river system and produces a list of the names of rivers in the system that have a pH level lower than 6.5.

;;(define (list-acidic-rivers a-river) empty) ;stub

;(define (list-acidic-rivers a-river)  ;;Template
;     (...  (river-ph a-river)
;           (list-acidic-rivers (river-tributaries a-river))))
;   
;   
(check-expect (list-acidic-rivers BEAVERHEAD) (list "Beaverhead"))
(check-expect (list-acidic-rivers BOULDER) empty)
(check-expect (list-acidic-rivers YELLOWSTONE) (list "Yellowstone" "Gardner" "Shields"))

(define (list-acidic-rivers a-river)
  (if (< (river-ph a-river) 6.5)
      (cons (river-name a-river) (list-acidic-rivers-list (river-tributaries a-river)))
      (list-acidic-rivers-list (river-tributaries a-river))))

;;list-acidic-rivers-list: ListOfRiver -> ListOfString
;;consumes a list of rivers and produces a list of the names of rivers in the system that have a pH level lower than 6.5.
;(define (list-acidic-rivers-list alor) empty) ;stub
; (define (list-acidic-rivers-list alor)
;     (cond [(empty? alor) (...)]
;           [(cons? alor)  (...  (list-acidic-rivers (first alor))
;                                (list-acidic-rivers-list (rest alor)))]))

(check-expect (list-acidic-rivers-list (list (make-river "Beaverhead" 4 6.4 empty))) (list "Beaverhead"))
(check-expect (list-acidic-rivers-list empty) empty)

(define (list-acidic-rivers-list alor)
  (cond [(empty? alor) empty]
        [(cons? alor) (append (list-acidic-rivers (first alor))
                             (list-acidic-rivers-list (rest alor)))]))

;;Question 5
;;SIGNATURE/PURPOSE
;;unhealthy?: River -> Boolean
;;consumes a river and returns true if any river in the system has a pH below 6.5 or over 8.5 or a DO under 6ppm.
;(define (unhealthy? a-river) true) ;stub
;(define (river-fcn a-river)
;     (...  (river-name a-river)
;           (river-ph a-river)
;           (river-do a-river)
;           (list-of-river-fcn (river-tributaries a-river))))

(check-expect (unhealthy? BEAVERHEAD) true)
(check-expect (unhealthy? BOULDER) false)
(check-expect (unhealthy? YELLOWSTONE) true)
(check-expect (unhealthy? MISSOURI) true)

(define (unhealthy? a-river)
  (if (or (< (river-ph a-river) 6.5) (> (river-ph a-river) 8.5) (< (river-do a-river) 6))
      true
      (unhealthy-check (river-tributaries a-river))))
;   
; ;; unhealthy-check:  ListOfRiver ->
; ;;
;(define (unhealthy-check alor) empty) ;stub
; (define (unhealthy-check alor)
;     (cond [(empty? alor) (...)]
;           [(cons? alor)  (...  (unhealthy? (first alor))
;                                (unhealthy-check (rest alor)))]))

(define (unhealthy-check alor)
  (cond [(empty? alor) false]
        [(cons? alor) (if (or (< (river-ph (first alor)) 6.5) (> (river-ph (first alor)) 8.5) (< (river-do (first alor)) 6))
                              (unhealthy? (first alor))
                              (unhealthy-check (rest alor)))]))

;;Question 6
;;SIGNATURE/PURPOSE
;;lower-all-ph: River -> River
;;consumes a river system and produces a river system with the pH of all the rivers in the system have been lowered by 0.3.

;;lower-all-ph-list: River -> River
;;consumes a river system and produces a river system with the pH of all the rivers in the system have been lowered by 0.3.

(check-expect (lower-all-ph BEAVERHEAD)
              (make-river "Beaverhead" 3.7 6.4 empty))
(check-expect (lower-all-ph BIG-HOLE)
              (make-river "Big Hole" 3.7 6.7 empty))
     (check-expect (lower-all-ph YELLOWSTONE)
              (make-river "Yellowstone" 4.7 8.5 (list (make-river "Gardner" 5.7 7.4 empty) (make-river "Shields" 5.7 3.7 empty) (make-river "Boulder" 6.7 7 empty))))

              
;;(define (lower-all-ph a-river) empty)    ;STUB

;(define (lower-all-ph a-river)  ;;Template
;     (...  (river-name a-river)
;           (... (river-ph a-river))
;           (river-do a-river)
;           (lower-all-ph-list (river-tributaries a-river))))
;     

(define (lower-all-ph a-river)  
  (make-river (river-name a-river)
              (- (river-ph a-river) 0.3)
              (river-do a-river)
              (lower-all-ph-list (river-tributaries a-river))))  

;(define (lower-all-ph-list a-river) empty)    ;STUB

; (define (unhealthy-check alor)
;     (cond [(empty? alor) (...)]
;           [(cons? alor)  (...  (lower-all-ph (first alor))
;                                (lower-all-ph-list (rest alor)))]))

(check-expect (lower-all-ph-list empty) empty)

(define (lower-all-ph-list alor)
  (cond [(empty? alor) empty]
        [(cons? alor)  (cons  (lower-all-ph (first alor))
                                (lower-all-ph-list (rest alor)))]))

;;Question 7
;;SIGNATRE/PURPOSE
;;find-subsystem: String River -> River/Boolean
;;consumes the name of a river and a river and produces either a portion of the original river that has the named river as its root or #false.
(check-expect (find-subsystem "Jefferson" MISSOURI)(make-river "Jefferson" 3 7.5 (list BEAVERHEAD BIG-HOLE)))
(check-expect (find-subsystem "Jefferson" YELLOWSTONE) false)
(check-expect (find-subsystem "Beaverhead" BEAVERHEAD) (make-river "Beaverhead" 4 6.4 empty))
(check-expect (find-subsystem "Boulder" MISSOURI) (make-river "Boulder" 7 7 empty))

;;(define (find-subsystem name a-river) false); stub
;(define (find-subsystem name a-river) ;;template
;     (...  (river-name a-river)
;           (river-ph a-river)
;           (river-do a-river)
;           (list-of-river-fcn name (river-tributaries a-river))))

(define (find-subsystem name a-river)
  (if (string=? name (river-name a-river))
      (make-river (river-name a-river) (river-ph a-river)(river-do a-river) (river-tributaries a-river))
      (find-subsystem-list name (river-tributaries a-river))))

; ;; find-subsystem-list:  ListOfRiver ->
; ;;(define (find-subsystem-list name alor) false) ;stub
; (define (find-subsystem-list name alor) ;template
;     (cond [(empty? alor) (...)]
;           [(cons? alor)  (...  (find-subsystem name (first alor))
;                                (find-subsystem-list name (rest alor)))]))
(define (find-subsystem-list name alor)
  (cond [(empty? alor) false]
        [(cons? alor) (sub-subsystem name alor)]))

(define (sub-subsystem name alor)
  (if (not(false? (find-subsystem name (first alor))))
      (find-subsystem name (first alor))
      (find-subsystem-list name (rest alor))))



;;PART 2

(define-struct menu-item (name kind vegetarian? quantity cost))
;;a Menu-item is a (make-menu-item String String Boolean Natural Number)
;;interp: represents a menu-item where
;;name is the name if the item
;;kind is the type of item (appetizer, entree, dessert, or beverage)
;;vegetarian? is whether or not the item is vegeterian
;;quantity is the amount of the items ordered
;;cost id the cost of a single item

(define MOMO (make-menu-item "Mo:Mo" "appetizer" #false 5 9.8))
(define RICE (make-menu-item "Rice" "entree" #true 2 3.5))
(define MOCHI (make-menu-item "Mochi" "dessert" #true 7 0.75))
(define FRIES (make-menu-item "Fries" "appetizer" #true 10 7.5))
(define LASI (make-menu-item "Lasi" "beverage" #true 1 0.5))
(define PASTA (make-menu-item "Pasta" "entree" #false 1 25))
(define SALAD (make-menu-item "salad" "appetizer" #true 5 8))
(define CAKE (make-menu-item "cake" "dessert" #false 1 12))
(define LEMONADE (make-menu-item "lemonade" "beverage" #true 1 3))
(define WATER (make-menu-item "Water" "beverage" #true 1 0.9))
(define FISH+CHIPS (make-menu-item "fish+chips" "entree" #false 1 18))
(define BAKEDPOTATO (make-menu-item "bakedpotato" "appetizer" #true 4 5))
(define ICECREAM (make-menu-item "icecream" "dessert" #false 1 3))

; ;; menu-item-fcn:  Menu-item -> ...
; ;; 
; (define (menu-item-fcn a-menu-item)
;   (... (menu-item-name a-menu-item)
;        (menu-item-kind a-menu-item)
;        (menu-item-vegetarian? a-menu-item)
;        (menu-item-quantity a-menu-item)
;        (menu-item-cost a-menu-item)))

;;an Order (ListOfMenu-item) is one of
;;   empty
;;   (cons menu-item Order)
;; interp: Order is a ListOfMenu-item

(define PARTY1 (cons MOMO (cons RICE (cons MOCHI (cons LASI empty)))))
(define PARTY2 (cons MOCHI (cons LASI empty)))
(define WPI (cons MOMO (cons RICE (cons MOCHI (cons FRIES (cons LASI empty))))))
(define ME (cons RICE (cons PASTA empty)))
(define HONO (cons FRIES (cons BAKEDPOTATO (cons PASTA (cons SALAD (cons LEMONADE empty))))))
(define ORDER1 (cons WATER (cons LASI (cons LEMONADE empty))))
(define ORDER2 (cons WATER (cons CAKE (cons FISH+CHIPS empty))))
(define ORDER3 (cons ICECREAM (cons CAKE (cons LEMONADE (cons ICECREAM (cons SALAD (cons LEMONADE empty)))))))

; ;; Order-fcn:  Order ->
; ;;
; (define (Order-fcn alomi)
;   (cond [(empty? alomi) empty]
;         [(cons? alomi)   (...        (menu-item-fcn (first alomi))
;                                     (Order-fcn (rest alomi)))]))

;;Question 8
;; dollar-menu-items:  ListOfMenu-items -> ListOfString
;; consumes a list of menu items and produces a list of the names of all the items with prices of $1 or less

(check-expect (dollar-menu-items PARTY1)
              (list "Mochi" "Lasi"))
(check-expect (dollar-menu-items ORDER2)
              (list "Water"))
(check-expect (dollar-menu-items empty) empty)

;(define (dollar-menu-items a-menu-item) empty)    ;Stub

(define (dollar-menu order)
    (local
      [(define (check-cost item)
      (<= (menu-item-cost item) 1))]
    (filter check-cost order)))

(define (dollar-menu-items order)
  (local
    [(define (name item)
       (menu-item-name item))]
    (map name (dollar-menu order))))


;;Question 9
;;SIGNATURE/PURPOSE
;; all-same-kind?:  ListOfMenu-item String -> Boolean
;; consumes a ListOfMenu-items and a kind of food and produces true if every item is of that kind

(check-expect (all-same-kind? PARTY1 "appetizer") #false)
(check-expect (all-same-kind? ORDER1 "beverage") #true)
(check-expect (all-same-kind? ME "entree") #true)

(define (all-same-kind? order kind)
  (local [(define (same? a-menu-item)
            (string=? (menu-item-kind a-menu-item) kind))]          
  (andmap same? order)))

;;Question 10
;;SIGNATURE/PURPOSE
;; list-expensive-vegetarian:  ListOfMenu-item Number -> ListOfMenu-item
;; consumes a list of menu items and returns a list of those vegetarian items that exceed the given amount
  
(check-expect (list-expensive-vegetarian ORDER1 2) (cons LEMONADE empty))
(check-expect (list-expensive-vegetarian ORDER2 3) (cons CAKE (cons FISH+CHIPS empty)))
(check-expect (list-expensive-vegetarian PARTY2 1) empty)

(define (list-expensive-vegetarian order price)
  (local [(define (expensive? a-menu-item)
            (> (menu-item-cost a-menu-item) price))]
    (filter expensive? order)))


