def log(message: String, level: String = "INFO") = println(s"$level: $message")

log("System starting")  // INFO: System starting
log("User not found", "WARNING")  // WARNING: User not found