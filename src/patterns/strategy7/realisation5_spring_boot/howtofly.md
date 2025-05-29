Зараз ми інтегруємо наш патерн Strategy у повноцінний Spring Boot застосунок, де:

Кожна стратегія буде окремим @Service

Користувач відправляє запит на /shout, передає фразу та стиль (type=1/2/3/4)

Система застосовує відповідну стратегію і повертає результат

🏗️ Структура проєкту:

src
└── main
└── java
└── com.example.strategy
├── StrategyApplication.java   <-- стартовий клас
├── controller
│   └── ShoutController.java
├── service
│   ├── ShoutingStrategy.java       <-- інтерфейс
│   ├── UpperCaseStrategy.java     <-- @Service
│   ├── LowerCaseStrategy.java
│   ├── ReverseStrategy.java
│   ├── DramaticStrategy.java
│   └── StrategyResolver.java      <-- логіка вибору

✅ Крок 1. Інтерфейс стратегії
package com.example.strategy.service;

public interface ShoutingStrategy {
String shout(String text);
int getType();  // 1, 2, 3, 4
}

✅ Крок 2. Конкретні стратегії
package com.example.strategy.service;
import org.springframework.stereotype.Service;

@Service
public class UpperCaseStrategy implements ShoutingStrategy {
public String shout(String text) {
return text.toUpperCase();
}

    public int getType() {
        return 1;
    }
}

@Service
public class LowerCaseStrategy implements ShoutingStrategy {
public String shout(String text) {
return text.toLowerCase();
}

    public int getType() {
        return 2;
    }
}

@Service
public class ReverseStrategy implements ShoutingStrategy {
public String shout(String text) {
return new StringBuilder(text).reverse().toString();
}

    public int getType() {
        return 3;
    }
}

@Service
public class DramaticStrategy implements ShoutingStrategy {
public String shout(String text) {
return String.join(" ", text.split(""));
}

    public int getType() {
        return 4;
    }
}

✅ Крок 3. Резольвер (вибір стратегії)
package com.example.strategy.service;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StrategyResolver {

    private final List<ShoutingStrategy> strategies;

    public StrategyResolver(List<ShoutingStrategy> strategies) {
        this.strategies = strategies;
    }

    public ShoutingStrategy resolve(int type) {
        return strategies.stream()
                .filter(s -> s.getType() == type)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown type: " + type));
    }
}

✅ Крок 4. REST-контролер
package com.example.strategy.controller;
import com.example.strategy.service.StrategyResolver;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shout")
public class ShoutController {

    private final StrategyResolver strategyResolver;

    public ShoutController(StrategyResolver strategyResolver) {
        this.strategyResolver = strategyResolver;
    }

    @GetMapping
    public String shout(@RequestParam String text, @RequestParam int type) {
        return strategyResolver.resolve(type).shout(text);
    }
}

✅ Крок 5. Головний клас
package com.example.strategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StrategyApplication {
public static void main(String[] args) {
SpringApplication.run(StrategyApplication.class, args);
}
}

🧪 Тестування:
Тепер запусти сервер і звернись через браузер або Postman:

http://localhost:8080/shout?text=hello&type=1  -> HELLO  
http://localhost:8080/shout?text=hello&type=2  -> hello  
http://localhost:8080/shout?text=hello&type=3  -> olleh  
http://localhost:8080/shout?text=hello&type=4  -> h e l l o
