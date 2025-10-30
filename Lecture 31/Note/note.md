Perfect 👍 Let’s go **step-by-step** — we’ll cover the **new Hibernate Criteria methodology** (i.e. **JPA Criteria API**) from **start to end**, clearly and simply.

---

## 🌱 Step 1: Understanding What Criteria API Is

**Criteria API** is a **type-safe**, **object-oriented** way of writing dynamic queries in Hibernate (and JPA).
Instead of writing HQL (strings like `"FROM Person WHERE age > 25"`), you build queries using Java objects.

👉 **Key advantage:**
If you make a typo in a property name, the compiler will catch it — unlike HQL strings.

---

## 🧩 Step 2: Setup — Prerequisites

Let’s assume you already have:

* Hibernate configured (using `hibernate.cfg.xml`)
* An entity class like `Person`

```java
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String city;

    // Getters and setters
}
```

---

## 🧠 Step 3: Creating the Criteria Query (Modern Method)

We’ll use classes from the **`jakarta.persistence.criteria`** package.

Here’s how it goes step-by-step:

### 1️⃣ Get `Session` and `CriteriaBuilder`

```java
Session session = factory.openSession();
CriteriaBuilder cb = session.getCriteriaBuilder();
```

* `CriteriaBuilder` is like a factory for building query objects.

---

### 2️⃣ Create `CriteriaQuery`

```java
CriteriaQuery<Person> cq = cb.createQuery(Person.class);
```

This defines the **type** of result you’ll get — here it’s `Person`.

---

### 3️⃣ Define the Root (the FROM clause)

```java
Root<Person> root = cq.from(Person.class);
```

* Think of `Root` as your `FROM Person` in SQL/HQL.
* It represents the main entity.

---

### 4️⃣ Add Selections (what to fetch)

```java
cq.select(root);
```

* This means: select * (all columns) from the Person table.

---

### 5️⃣ Add Restrictions / Conditions (WHERE clause)

To filter results, use **Predicates**.

Example — fetch all persons where age > 25:

```java
Predicate ageGreater = cb.gt(root.get("age"), 25);
cq.where(ageGreater);
```

You can also add multiple conditions using `and()` or `or()`:

```java
Predicate nameStarts = cb.like(root.get("name"), "A%");
cq.where(cb.and(ageGreater, nameStarts));
```

---

### 6️⃣ Create Query and Execute

```java
Query<Person> query = session.createQuery(cq);
List<Person> people = query.getResultList();
```

---

### 7️⃣ Print Results

```java
for (Person p : people) {
    System.out.println(p.getName() + " - " + p.getAge());
}
```

---

## 🧾 Full Example — Clean & Working Code

```java
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.criteria.*;

import java.util.List;

public class CriteriaExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            // 1️⃣ Get CriteriaBuilder
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // 2️⃣ Create CriteriaQuery
            CriteriaQuery<Person> cq = cb.createQuery(Person.class);

            // 3️⃣ Define Root
            Root<Person> root = cq.from(Person.class);

            // 4️⃣ Add condition
            Predicate predicate = cb.gt(root.get("age"), 25);
            cq.select(root).where(predicate);

            // 5️⃣ Execute query
            List<Person> results = session.createQuery(cq).getResultList();

            // 6️⃣ Display results
            for (Person p : results) {
                System.out.println(p.getName() + " - " + p.getAge());
            }

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
```

---

## 💡 Commonly Used Restrictions (Predicates)

| CriteriaBuilder Method                | Equivalent SQL   | Example            |
| ------------------------------------- | ---------------- | ------------------ |
| `cb.equal(root.get("city"), "Delhi")` | `city = 'Delhi'` | Equality           |
| `cb.gt(root.get("age"), 25)`          | `age > 25`       | Greater than       |
| `cb.ge(root.get("age"), 25)`          | `age >= 25`      | Greater or equal   |
| `cb.lt(root.get("age"), 25)`          | `age < 25`       | Less than          |
| `cb.like(root.get("name"), "A%")`     | `name LIKE 'A%'` | Starts with A      |
| `cb.and(p1, p2)`                      | `AND`            | Combine conditions |
| `cb.or(p1, p2)`                       | `OR`             | Combine with OR    |

---

## 🔍 Bonus: Sorting Results

```java
cq.orderBy(cb.asc(root.get("name"))); // ascending
cq.orderBy(cb.desc(root.get("age"))); // descending
```

---

## 🧠 In Summary

| Step | What It Does                                 |
| ---- | -------------------------------------------- |
| 1️⃣  | Get `CriteriaBuilder` from session           |
| 2️⃣  | Create a `CriteriaQuery` for your entity     |
| 3️⃣  | Define `Root` (like FROM)                    |
| 4️⃣  | Add `where`, `select`, and `orderBy` clauses |
| 5️⃣  | Execute using `createQuery()`                |
| 6️⃣  | Get results                                  |

---

Would you like me to show how to **combine multiple conditions** (like `age > 25 AND city = 'Delhi'`) in the same query next?
