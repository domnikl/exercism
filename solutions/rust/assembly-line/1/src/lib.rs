pub fn production_rate_per_hour(speed: u8) -> f64 {
    assert!(speed <= 10);

    let success_rate = match speed {
        0 => 0,
        1..=4 => 100,
        5..=8 => 90,
        9..=u8::MAX => 77,
    };

    (f64::from(speed) * 221.0) / 100. * f64::from(success_rate)
}

pub fn working_items_per_minute(speed: u8) -> u32 {
    (production_rate_per_hour(speed) / 60.).round() as u32
}
