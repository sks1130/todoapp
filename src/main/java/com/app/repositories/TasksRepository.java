/*
 *  This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.app.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.models.Tasks;


/**
 * 
 * @author Sachin Srivastava
 *
 */

public interface TasksRepository extends JpaRepository<Tasks, Long> {

	Collection<Tasks> findBytaskname(String taskname);
	Collection<Tasks> findBytasknameStartsWithIgnoreCase(String taskname);
	
	@Query("select new map (T.id as id, T.taskname as taskname, T.performdate as performdate, T.category as category, T.priority as priority, T.isdone as isdone) from Tasks T")
	Collection<Tasks> findAllCustom();
	
}
