;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname cheung-a-gauro-s-hw6) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #t)))
;;Allen Cheung & Sakshi Gauro
;;acheung & sgauro

;;Question 1
(define-struct message (username text read?))
;; a Message is a (make-message String String Boolean)
;;interp: represents a message where
;;  --username is the name of the sender
;;  --text is thetext of the message
;;  --read? is the flag indicating whether or not the user has read the message
(define MESSAGE1 (make-message "User1" "Hello" false))
(define MESSAGE2 (make-message "User2" "Hey" true))
(define MESSAGE3 (make-message "User3" "Help" false))
(define MESSAGE4 (make-message "User4" "Computer Science" true))
(define MESSAGE5 (make-message "User5" "Hard" false))
(define MESSAGE6 (make-message "User6" "Homework" true))
(define MESSAGE7 (make-message "User7" "Long" false))
(define MESSAGE8 (make-message "User8" "End this" true))

(define-struct user (username mailbox))
;; a User is a (make-user String ListOfMessage)
;;interp: represents a user where
;;  --username is the name of the user
;;  --mailbox is the list of the messages in the mailbox

;;an Email-System (ListOfUser) is one of
;;   empty
;;   (cons ListOfUser)
;; interp: Email-System is a ListOfUser

(define USER1 (make-user "User1" (cons MESSAGE2 (cons MESSAGE3 (cons MESSAGE4 (cons MESSAGE5 empty))))))
(define USER2 (make-user "User2" empty))
(define USER3 (make-user "User3" (cons MESSAGE2 (cons MESSAGE4 (cons MESSAGE6 (cons MESSAGE8 empty))))))
(define USER4 (make-user "User4" (cons MESSAGE1 empty)))

;;----------------------------------------------------------------------------------------------------
;;Question 2
;;mailsys is a empty Email-System
;;remembers information about each user who uses email
(define mailsys (list empty))
(set! mailsys (list USER1 USER2 USER3 USER4))

;;newuser is a User
;;remembers information about a user and their messages
(define newuser (make-user "Newuser" empty))

;;----------------------------------------------------------------------------------------------------
;;Question 3
;;add-user: String -> void
;;consumes a username to extend the list of users
;;EFFECT: adds a new user with the given username to mailsys


(define (add-user username)
  (set! mailsys (cons (make-user username empty) mailsys)))

(add-user "User5")


;;----------------------------------------------------------------------------------------------------
;;Question 4
;;send-email: String String String -> void
;;consumes the name of the sender, name of the recipient, to extend list of message
;;EFFECT: store a new unread message in the recipient's mailbox


(define (send-email s-name r-name mess)
  (set! mailsys (send-into-list s-name r-name mess mailsys)))

(define (send-into-list s-name r-name mess alom)
  (cond [(empty? alom) (error "no such account")]
        [(cons?  alom)
         (if (string=? r-name (user-username (first alom)))
             (cons (make-user
                    r-name
                    (make-message s-name mess false))
                   (rest alom))
             (cons (first alom) (send-into-list s-name r-name mess (rest alom))))]))


;;----------------------------------------------------------------------------------------------------
;;Question 5
;;get-unread-messages: String -> ListOfMessage
;;consumes a username and produces a list of messages that contains the unread messages in the mailbox of the user with the given name
;;EFFECT: all unread messages in the named user's mailbox have been set to read

(define (mesred message)
  (not (message-read? message)))

(define (get-unread-messages name)
  (if (not(boolean? (check-name name mailsys)))
      (is-unread (check-name name mailsys) name)
      "Failed"))

(define (is-unread ms name)
  (local [(define TEMPLIST empty)]
    (begin (cond [(empty? ms) empty]
                 [(cons? ms) (set! TEMPLIST (append TEMPLIST (filter mesred ms)))]
                 [else empty])
           (set-message-read?!
            (local[(define (check-red ms)
                     (cond[(empty? ms) empty]
                          [(cons? ms) (begin (check-red (rest ms)) (first ms))]))](check-red ms))
            true)
           TEMPLIST)))

(define (check-name name list)
  (if (string=? name (user-username (first list)))
      (user-mailbox (first list))
      (if (not (empty? (rest list)))
          (check-name name (rest list))
          false)))


;;----------------------------------------------------------------------------------------------------
;;Question 6
;;most-messages:    -> User
;;produces the user in the mailsystem with the largest number of messages in his/her mailbox.
;;If there are no users in the system, the function produces an appropriate error.
;;If two or more users have the most messages, the function just needs to return one of them (it doesn't matter which one)

(define THE-MOST (make-user "Temporary" empty))

;;HELPER FUNCTION
;;num-of-msg: ListOfMessage -> Natural
;;consumes a ListOfMessage and produces the number of messages in the system



;;greatest: User User -> User
;;consumes two User and sets THE-MOST to the user with the largest number of messages

(define (most-messages)
  (if (empty? mailsys)
      "There is no user in the system"
      (local [(define (acc-mb mailsys max accumulator)
                (if (empty? mailsys)
                    accumulator
                    (if (>= (length (user-mailbox (first mailsys))) max)
                        (acc-mb (rest mailsys) (length (user-mailbox (first mailsys))) (first mailsys))
                        (acc-mb (rest mailsys) max accumulator))))]
                    (acc-mb mailsys 0 empty))))

;;----------------------------------------------------------------------------------------------------
;;Question 8
;;total-string-length: ListOfString -> Number
;;consumes a ListOfString and produces the sum of the lengths of the strings in the list.

(check-expect (total-string-length (list "Hi" "Yo" "Yes")) 7)
(check-expect (total-string-length (list "This" "is" "so" "boring")) 14)


(define (total-string-length los)
  (local
    [(define (string-acc los accu)
       (cond [(empty? los) accu]
             [(cons? los) (string-acc (rest los) (+ accu (string-length(first los))))]))]
    (string-acc los 0)))


;;----------------------------------------------------------------------------------------------------
;;Question 9
;;one-giant-string: ListOfString -> String
;;consumes a ListOfString and produces the concatenation of strings

(check-expect (one-giant-string (list "Hi" "Yo" "Yes")) "HiYoYes")
(check-expect (one-giant-string (list "This" "is" "so" "boring")) "Thisissoboring")
                                   
(define (one-giant-string los)
  (local
    [(define (string-acc los accu)
       (cond [(empty? los) accu]
             [(cons? los) (string-acc (rest los) (string-append accu (first los)))]))]
    (string-acc los "")))





