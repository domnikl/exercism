use time::PrimitiveDateTime as DateTime;
use std::time::Duration;

// Returns a DateTime one billion seconds after start.
pub fn after(start: DateTime) -> DateTime {
    start + Duration::from_secs(10u64.pow(9))
}
