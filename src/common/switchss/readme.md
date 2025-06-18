        return switch (s) {
            case "^[a-Z] " -> "VISA";
            case "2" -> " " ;
            case "3" -> " ";
            default -> " ";
        };