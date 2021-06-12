package dummy;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckIndicator implements HealthIndicator {
	
	@Autowired
	CustomCodeStatusMapper mapper;

	@Autowired
	Status status;
	
	@Override
	public Health health() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("sayantan", "chatterjee");
		
		if (mapper.getStatusCode(status) == 200) {
			return Health.up().withDetails(map).build();
		} 
		return Health.down().withDetails(map).build();
	}
}
