# Day 4: Simple Validator

## Task

Write a function that takes in 2 strings. The first one is the `email address`, the second one is the `password` and returns an object specified below.

Verify that the email address is valid. If valid, create an object with property `email` and assign as `true` else, assign as `false`. For the password verify that it has at least one Uppercase letter, at least one lowercase letter, at least one non-alphanumeric character, at least one number and at least 8 character long. if the password is valid, let the object have property `password` assigned to `true` else, `false`.

Example:

```java
validate(
    "akinwandeakiboluwarin@gmail.com",
    "YOucan'tgetmyPassword2"
) // {email: true, password: true}

validate(
    "ichigokurosaki@gmail.com",
    "getsugaTensho"
) // { email: true, password:false }

validate(
    "ichigokurosakigmail.com",
    "getsugaTensho"
) // { email: false, password:false }
```

To run the script, run

```bash
javac AuthValidator.java
javac Main.java
java Main.java <email> <password>
```
